package Ex_4

// Função principal onde executaremos o programa
fun main() {
    val funcionarios = mutableListOf<Funcionario>()

    // Loop do menu principal, que só termina quando o usuário escolhe sair
    while (true) {
        println("\nEscolha uma opção:")
        println("a) Cadastrar os 20 funcionários")
        println("b) Pesquisar funcionário por matrícula")
        println("c) Apresentar funcionários com salário acima de R$1.000,00")
        println("d) Apresentar funcionários com salário abaixo de R$1.000,00")
        println("e) Apresentar funcionários com salário igual a R$1.000,00")
        println("f) Sair do programa")

        val opcao = readLine()

        when (opcao) {
            "a" -> cadastrarFuncionarios(funcionarios)
            "b" -> pesquisarFuncionario(funcionarios)
            "c" -> exibirSalarioAcima(funcionarios, 1000.0)
            "d" -> exibirSalarioAbaixo(funcionarios, 1000.0)
            "e" -> exibirSalarioIgual(funcionarios, 1000.0)
            "f" -> {
                println("Saindo do programa.")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

// Função para cadastrar até 20 funcionários e ordenar por matrícula
fun cadastrarFuncionarios(funcionarios: MutableList<Funcionario>) {
    if (funcionarios.size >= 20) {
        println("Já foram cadastrados 20 funcionários.")
        return
    }

    for (i in 1..20) {
        println("Digite a matrícula do funcionário $i:")
        val matricula = readLine()?.toIntOrNull()
        println("Digite o nome do funcionário $i:")
        val nome = readLine() ?: ""
        println("Digite o salário do funcionário $i:")
        val salario = readLine()?.toDoubleOrNull()

        if (matricula != null && salario != null) {
            funcionarios.add(Funcionario(matricula, nome, salario))
        } else {
            println("Dados inválidos, tente novamente.")
        }

        if (funcionarios.size == 20) break
    }

    // Ordena os funcionários pela matrícula para manter a lista organizada
    funcionarios.sortBy { it.matricula }
}

// Função para pesquisar um funcionário pela matrícula
fun pesquisarFuncionario(funcionarios: List<Funcionario>) {
    println("Digite a matrícula do funcionário que deseja pesquisar:")
    val matricula = readLine()?.toIntOrNull()

    if (matricula != null) {
        val funcionario = funcionarios.find { it.matricula == matricula }
        if (funcionario != null) {
            println("Funcionário encontrado: $funcionario")
        } else {
            println("Funcionário com matrícula $matricula não encontrado.")
        }
    } else {
        println("Matrícula inválida.")
    }
}

// Função para exibir funcionários com salário acima de um valor especificado
fun exibirSalarioAcima(funcionarios: List<Funcionario>, salarioMin: Double) {
    println("Funcionários com salário acima de R$${salarioMin}:")
    funcionarios.filter { it.salario > salarioMin }
        .sortedBy { it.matricula }
        .forEach { println(it) }
}

// Função para exibir funcionários com salário abaixo de um valor especificado
fun exibirSalarioAbaixo(funcionarios: List<Funcionario>, salarioMax: Double) {
    println("Funcionários com salário abaixo de R$${salarioMax}:")
    funcionarios.filter { it.salario < salarioMax }
        .sortedBy { it.matricula }
        .forEach { println(it) }
}

// Função para exibir funcionários com salário igual a um valor especificado
fun exibirSalarioIgual(funcionarios: List<Funcionario>, salarioIgual: Double) {
    println("Funcionários com salário igual a R$${salarioIgual}:")
    funcionarios.filter { it.salario == salarioIgual }
        .sortedBy { it.matricula }
        .forEach { println(it) }
}