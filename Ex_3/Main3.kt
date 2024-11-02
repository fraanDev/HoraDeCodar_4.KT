package Ex_3

// Função principal onde executaremos o programa
fun main() {
    // Lista que vai armazenar os registros de até 15 pessoas
    val pessoas = mutableListOf<Pessoa>()

    // Laço para o menu que executará enquanto o usuário não optar por sair
    while (true) {
        // Exibição do menu de opções
        println("\nSelecione uma opção:")
        println("a) Cadastrar os 15 registros")
        println("b) Apresentar pessoas com altura menor ou igual a 1.5m")
        println("c) Apresentar pessoas com altura maior que 1.5m")
        println("d) Apresentar pessoas com altura entre 1.5m e 2.0m")
        println("e) Calcular e mostrar a média de todas as alturas")
        println("f) Sair do programa")

        // Leitura da escolha do usuário
        val escolha = readLine()

        // Estrutura de decisão para cada opção do menu
        when (escolha) {
            "a" -> cadastrarPessoas(pessoas)
            "b" -> exibirMenorOuIgual(pessoas, 1.5)
            "c" -> exibirMaior(pessoas, 1.5)
            "d" -> exibirIntervalo(pessoas, 1.5, 2.0)
            "e" -> calcularMediaAlturas(pessoas)
            "f" -> {
                println("Saindo do programa.")
                break // Encerra o loop e finaliza o programa
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

// Função para cadastrar até 15 registros de pessoas
fun cadastrarPessoas(pessoas: MutableList<Pessoa>) {
    // Verifica se a lista já contém 15 registros
    if (pessoas.size >= 15) {
        println("O limite de 15 pessoas já foi atingido.")
        return
    }

    // Laço para cadastro de cada pessoa
    for (i in 1..15) {
        println("Digite o nome da pessoa $i:")
        val nome = readLine() ?: ""
        println("Digite a altura da pessoa $i (em metros):")
        val altura = readLine()?.toDoubleOrNull()

        // Verificação de entrada de altura válida
        if (altura != null) {
            pessoas.add(Pessoa(nome, altura))
        } else {
            println("Altura inválida, cadastro não realizado para essa entrada.")
        }

        // Verifica se a lista chegou a 15 pessoas para parar
        if (pessoas.size == 15) {
            break
        }
    }
}

// Função para exibir pessoas com altura menor ou igual a um valor específico
fun exibirMenorOuIgual(pessoas: List<Pessoa>, limiteAltura: Double) {
    println("Pessoas com altura menor ou igual a $limiteAltura m:")
    pessoas.filter { it.altura <= limiteAltura }
        .forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

// Função para exibir pessoas com altura maior que um valor específico
fun exibirMaior(pessoas: List<Pessoa>, limiteAltura: Double) {
    println("Pessoas com altura maior que $limiteAltura m:")
    pessoas.filter { it.altura > limiteAltura }
        .forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

// Função para exibir pessoas com altura dentro de um intervalo
fun exibirIntervalo(pessoas: List<Pessoa>, alturaMin: Double, alturaMax: Double) {
    println("Pessoas com altura entre $alturaMin m e $alturaMax m:")
    pessoas.filter { it.altura > alturaMin && it.altura < alturaMax }
        .forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

// Função para calcular e exibir a média das alturas armazenadas
fun calcularMediaAlturas(pessoas: List<Pessoa>) {
    if (pessoas.isEmpty()) {
        println("Nenhuma pessoa cadastrada.")
        return
    }

    // Calcula a média somando todas as alturas e dividindo pelo total de pessoas
    val media = pessoas.sumOf { it.altura } / pessoas.size
    println("A média das alturas cadastradas é: %.2f m".format(media))
}
