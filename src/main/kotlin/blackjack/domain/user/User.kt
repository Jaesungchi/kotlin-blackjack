package blackjack.domain.user

import blackjack.constant.ErrorMessages
import blackjack.domain.OutputInterface
import blackjack.domain.card.Card
import blackjack.domain.card.Cards
import blackjack.domain.card.Deck
import blackjack.view.InputView

/**
 * 유저데이터를 갖고 있는 클래스
 * Created by Jaesungchi on 2022.06.07..
 */
open class User(val name: String, initCards: List<Card>) {
    private val _cards: Cards = Cards().apply {
        initCards.map {
            addCard(it)
        }
    }
    val cards: Cards
        get() = _cards

    init {
        require(name.isNotEmpty()) { ErrorMessages.NAME_IS_EMPTY }
    }

    fun hit(card: Card) {
        _cards.addCard(card)
    }

    private fun isBust(): Boolean {
        return _cards.getScore().isBust()
    }

    private fun isBlackJack(): Boolean {
        return _cards.getSize() == Users.INIT_CARD_SIZE &&
            _cards.getScore().isBlackJackScore()
    }

    fun match(user: User): Match {
        if (isBust() && user.isBust())
            return Match.DRAW
        else if (user.isBust())
            return Match.WIN
        else if (isBust())
            return Match.LOSE

        if (isBlackJack() && user.isBlackJack())
            return Match.DRAW
        else if (isBlackJack())
            return Match.WIN
        else if (user.isBlackJack())
            return Match.LOSE

        return if (user._cards.getScore() < _cards.getScore())
            Match.WIN
        else if (user._cards.getScore() > _cards.getScore())
            Match.LOSE
        else
            Match.DRAW
    }

    open fun hitStage(deck: Deck, output: OutputInterface) {
        while (!isBust()) {
            output.drawMoreCard(this)
            if (!InputView.getYesOrNo()) return
            hit(deck.takeCard())
            output.drawUserCard(this)
        }
    }
}

enum class Match {
    WIN, LOSE, DRAW
}
