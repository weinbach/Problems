package leetcode.solved.string

import java.lang.StringBuilder

//1405. Longest Happy String
fun longestDiverseString(a: Int, b: Int, c: Int): String {
    var aa = a
    var bb = b
    var cc = c

    val res = StringBuilder()

    var currA = 0
    var currB = 0
    var currC = 0


    for(i in 0..(a+b+c)){
        if(aa>0 && ((currA!=2 && aa>=bb && aa>=cc) || currB==2 || currC==2)){
            res.append("a")
            currA++
            currB=0
            currC=0
            aa--
            continue
        }
        if(bb>0 && ((currB!=2 && bb>=aa && bb>=cc) || currA==2 || currC==2)){
            res.append("b")
            currA=0
            currB++
            currC=0
            bb--
            continue
        }
        if(cc>0 && ((currC!=2 && cc>=bb && cc>=aa) || currB==2 || currA==2)){
            res.append("c")
            currA=0
            currB=0
            currC++
            cc--
            continue
        }
    }
    return res.toString()
}