package learn.app.network

sealed interface Result<T>
class Loading<T>() : Result<T>
class Success<T>(data: T) : Result<T>
class Error<T>(errorCode: Int, message: String) : Result<T>
