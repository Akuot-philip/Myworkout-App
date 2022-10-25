package dev.akuot.workoutlog.repository

import dev.akuot.mypost.APIClient
import dev.akuot.workoutlog.WorkoutLog
import dev.akuot.workoutlog.api.ApiInterface
import dev.akuot.workoutlog.database.WorkoutDb
import dev.akuot.workoutlog.models.ExerciseCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ExerciseRepository {
    val apiClient = APIClient.buildApiClient(ApiInterface::class.java)
    val database =  WorkoutDb.getDatabase(WorkoutLog.appContext)
    val exerciseCategoryDao =database .exerciseCategoryDao()

    suspend fun fetchExerciseCategories(accessToken: String) : Response<List<ExerciseCategory>> {
       return withContext(Dispatchers.IO){
           var response =apiClient.fetchExerciseCategories(accessToken)
           if (response.isSuccessful){
               var category =response.body()
               category?.forEach {
                   category-> exerciseCategoryDao.insertExerciseCategory(category)
               }
           }
          response


       }
}
}