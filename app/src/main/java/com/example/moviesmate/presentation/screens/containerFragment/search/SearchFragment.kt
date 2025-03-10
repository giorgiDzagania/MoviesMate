package com.example.moviesmate.presentation.screens.containerFragment.search

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesmate.databinding.FragmentSearchBinding
import com.example.moviesmate.core.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val viewModel by viewModel<SearchViewModel>()
    private val categoryAdapter = CategoryAdapter()
    private val searchAdapter = SearchAdapter()
    private val searchedSpecificGenreAdapter = SearchedSpecificGenreAdapter()
    private val loadStateAdapter = MovieLoadStateAdapter()

    override fun viewCreated() {
        prepareRecyclerViews()
        setListeners()
        setCollectors()
    }

    private fun prepareRecyclerViews() {
        binding.categoriesRecyclerView.adapter = categoryAdapter

        binding.searchRecyclerView.apply {
            adapter = searchAdapter.withLoadStateFooter(loadStateAdapter)
            layoutManager = GridLayoutManager(
                requireContext(),
                2, GridLayoutManager.VERTICAL, false
            )
        }

        binding.chooseGenreRecyclerview.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2, GridLayoutManager.VERTICAL, false
            )
            adapter = searchedSpecificGenreAdapter.withLoadStateFooter(loadStateAdapter)
        }
    }

    private fun setListeners() {
        categoryAdapter.onGenreClick = { selectedGenre ->
            categoryAdapter.updateSelectedGenre(selectedGenre.id)
            binding.searchRecyclerView.visibility = View.GONE
            binding.chooseGenreRecyclerview.visibility = View.VISIBLE
            viewModel.getGenreMovies(selectedGenre.id)

            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getGenreMovies(selectedGenre.id).collectLatest { pagingData ->
                        searchedSpecificGenreAdapter.submitData(pagingData)
                    }
                }
            }
        }

        searchedSpecificGenreAdapter.onItemClick = { currentMovie ->
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    currentMovie.id
                )
            )
        }

        searchAdapter.onItemClick = { currentMovie ->
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    currentMovie.id
                )
            )
        }

        binding.btnSearch.setOnClickListener {
            goToSearchInputFragment()
        }

        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun goToSearchInputFragment() {
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToSearchInputFragment())
    }

    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.genresFlow.collect { genres ->
                    categoryAdapter.submitList(genres)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryMoviesFlow.collect { allMovies ->
                    searchAdapter.submitData(allMovies)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.showError.collect { error ->
                    Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isLoadingState.collect { isLoading ->
                    binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
                }
            }
        }
    }
}