package Ex_2

data class Alunos(
var nome: String,
var notas: List<Double>
) {
    // Calcula a média do aluno
    fun calcularMedia(): Double {
        return notas.average()
    }

    // Retorna "Aprovado" ou "Reprovado" com base na média
    fun status(): String {
        return if (calcularMedia() >= 5.0) "Aprovado" else "Reprovado"
    }
}

