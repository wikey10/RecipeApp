package com.app.recipeapp

sealed class Screens(val route:String) {

object RecipeScreen:Screens("recipeScreen")
object DetailScreen:Screens("detailScreen")

}