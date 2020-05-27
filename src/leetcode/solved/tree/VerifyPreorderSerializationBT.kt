package leetcode.solved.tree

import java.util.*

//#331 Verify preorder serialization of Binary Tree
fun isValidSerialization(preorder: String): Boolean {

    val stack = Stack<String>()
    val empties = Stack<Int>()
    val elements: List<String> = preorder.split(",")

    if (elements.size == 1) {
        return elements[0] == "#"
    }
    if (elements[0] == "#") {
        return false
    }

    for (i in elements.indices) {

        if (elements[i] == "#"){
            if(empties.isEmpty())
                return false
            else{
                empties.push(empties.pop()+1)
                while (empties.lastElement() == 2){
                    empties.pop()
                    stack.pop()
                    if(empties.isEmpty() && i!=elements.size-1)
                        return false
                    if(empties.isEmpty())
                        break
                    empties.push(empties.pop()+1)
                }
            }
        }

        else{
            stack.push(elements[i])
            empties.push(0)
        }
    }

    return stack.isEmpty()
}

fun main() {
    print(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#"))

}