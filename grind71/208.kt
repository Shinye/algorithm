class Trie() {

    /*
        빠른 탐색을 위해 key-value 형태로 저장한다
        이 때 key는 알파펫 첫 글자
     */

    // arrayOf썼다가.. mutable하지못해 헤맴
    val insertedMap: MutableMap<Char, MutableList<String>> = mutableMapOf()

    fun insert(word: String) {
        val first = word[0]
        if (insertedMap[first] == null) {
            insertedMap[first] = mutableListOf(word)
        } else {
            insertedMap[first]?.add(word)
        }
    }

    fun search(word: String): Boolean {
        val first = word[0]
        return insertedMap.keys.find { it == first }?.let { c ->
            insertedMap[c]!!.find { it == word } != null
        } ?: false
    }

    fun startsWith(prefix: String): Boolean {
        val first = prefix[0]
        return insertedMap.keys.find { it == first }?.let { c ->
            insertedMap[c]!!.find { it.startsWith(prefix) } != null
        } ?: false
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */