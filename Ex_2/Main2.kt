package Ex_2

fun main() {
    val alunos = ArrayList<Alunos>()
    var opcao: Int

    do {
        println("Qual a Nota? - Escolha uma opção:")
        println("1. Cadastrar alunos")
        println("2. Pesquisar aluno pelo nome")
        println("3. Apresentar todos os registros")
        println("4. Sair")

        print("Digite sua opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarAlunos(alunos)
            2 -> pesquisarAluno(alunos)
            3 -> exibirTodosRegistros(alunos)
            4 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 4)
}

fun cadastrarAlunos(alunos: ArrayList<Alunos>) {
    println("\nCadastro de alunos:")
    for (i in 1..20) {
        println("Cadastro do aluno ${i}:")

        print("Nome: ")
        val nome = readLine() ?: ""

        val notas = mutableListOf<Double>()
        for (j in 1..4) {
            print("Nota $j: ")
            val nota = readLine()?.toDoubleOrNull() ?: 0.0
            notas.add(nota)
        }

        alunos.add(Alunos(nome, notas))
    }

    // Classificar os alunos por ordem alfabética de nome
    alunos.sortBy { it.nome }
    println("Cadastro concluído e alunos ordenados por nome.\n")
}

fun pesquisarAluno(alunos: ArrayList<Alunos>) {
    print("\nDigite o nome do aluno para buscar: ")
    val nomeBuscado = readLine() ?: ""

    val aluno = alunos.find { it.nome.equals(nomeBuscado, ignoreCase = true) }

    if (aluno != null) {
        val media = aluno.calcularMedia()
        val status = aluno.status()
        println("Aluno: ${aluno.nome}, Média: ${"%.2f".format(media)}, Status: $status\n")
    } else {
        println("Nenhum aluno encontrado com o nome \"$nomeBuscado\".\n")
    }
}

fun exibirTodosRegistros(alunos: ArrayList<Alunos>) {
    println("\nLista de todos os alunos:")
    alunos.forEach { aluno ->
        val media = aluno.calcularMedia()
        val status = aluno.status()
        println("Nome: ${aluno.nome}, Média: ${"%.2f".format(media)}, Status: $status")
    }
    println()
}
