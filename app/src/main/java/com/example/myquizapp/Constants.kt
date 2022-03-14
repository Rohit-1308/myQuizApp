package com.example.myquizapp

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionlist=ArrayList<Question>()

        val que1=Question(
            1,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_usa,
            "ARGENTINA","RUSSIA",
            "USA","INDIA",3
        )
        questionlist.add(que1)
        val que2=Question(
            3,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_indiapng,
            "ARGENTINA","RUSSIA",
            "CHINA","INDIA",4
        )
        questionlist.add(que2)
        val que3=Question(
            3,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_ukraine,
            "ARGENTINA","RUSSIA",
            "UKRIANE","INDIA",3
        )
        questionlist.add(que3)
        val que4=Question(
            4,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_vietnam,
            "ARGENTINA","RUSSIA",
            "PAKISTAN","VIETNAM",4
        )
        questionlist.add(que4)
        val que5=Question(
            5,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_russia,
            "ARGENTINA","RUSSIA",
            "UKRAINE","INDIA",2
        )
        questionlist.add(que5)
  val que7=Question(
            7,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_bhutan,
            "ARGENTINA","RUSSIA",
            "UKRAINE","BHUTAN",4
        )
        questionlist.add(que7)
val que8=Question(
            8,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_france,
            "ARGENTINA","EK",
            "UAE","FRANCE",4
        )
        questionlist.add(que8)
val que9=Question(
            9,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_canada,
            "ARGENTINA","RUSSIA",
            "CANADA","UK",3
        )
        questionlist.add(que9)
val que10=Question(
            10,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_japan,
            "JAPNAN","RUSSIA",
            "UKRAINE","CHINA",3
        )
        questionlist.add(que10)
val que11=Question(
            11,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,
            "BANGLADESH","RUSSIA",
            "UKRAINE","PAKISTAN",1
        )
        questionlist.add(que11)

        return questionlist
    }

}