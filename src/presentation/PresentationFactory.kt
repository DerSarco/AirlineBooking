package presentation

import domain.presentation.Formatter

interface PresentationFactory<T> {
    fun getPresentationFormat(format: PresentationFormat): Formatter<T>
}