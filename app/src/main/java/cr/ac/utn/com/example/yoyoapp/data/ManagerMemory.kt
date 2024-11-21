package cr.ac.utn.com.example.yoyoapp.data

object ManagerMemory {
    private val data = mutableListOf<Any>()

    fun add(item: Any) {
        data.add(item)
    }

    fun getAll(): List<Any> {
        return data
    }

    fun update(item: Any) {
        val index = data.indexOfFirst { it == item }
        if (index != -1) {
            data[index] = item
        }
    }

    fun getByid(id: String): Any? {
        return data.find { (it as? Identifiable)?.id == id }
    }

    fun remove(item: Any) {
        data.remove(item)
    }
}

interface Identifiable {
    val id: String
}

