package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Answer
import no.nav.rapid.Assessment
import no.nav.rapid.Message
import no.nav.rapid.Question


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)
        if (question.category == "arithmetic") handleAritmethics(question)
    }

    private fun handleAritmethics(question: Question) {
        val chars = question.question.split(" ")
        when(chars[1]){
            "-" -> answer(question.category, questionId = question.id(), (chars[0].toInt() - chars[2].toInt()).toString())
            "+" -> answer(question.category, questionId = question.id(), (chars[0].toInt() + chars[2].toInt()).toString())
            "/" -> answer(question.category, questionId = question.id(), (chars[0].toInt() / chars[2].toInt()).toString())
            "*" -> answer(question.category, questionId = question.id(), (chars[0].toInt() * chars[2].toInt()).toString())
        }
    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleRegisterTeam(question: Question){
        answer(question.category, questionId = question.id(), "nirodis")
    }

}