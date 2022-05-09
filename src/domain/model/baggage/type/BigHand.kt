package domain.model.baggage.type

class BigHand() : BaggageType() {
    // "🎒🎒"
    override val emoji: String
        get() = super.emoji + super.emoji
    override val title: String = "Big Hand Baggage"

}