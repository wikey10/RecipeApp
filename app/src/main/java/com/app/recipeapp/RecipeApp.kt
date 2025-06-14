package com.app.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun RecipeApp(navController: NavHostController,modifier: Modifier){
    val recipeModel :MainViewModel = viewModel()

    val viewState by recipeModel.categoriesState


    NavHost(navController = navController, startDestination = Screens.RecipeScreen.route){
        composable(route = Screens.RecipeScreen.route){
            RecipeScreen(modifier,navigateToDetail = {


                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screens.DetailScreen.route)
            }, viewState = viewState)
        }
        composable(route = Screens.DetailScreen.route){
            val  category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?:Category(idCategory = "","","","")
            DetailScreen(modifier,category)
        }
    }


}