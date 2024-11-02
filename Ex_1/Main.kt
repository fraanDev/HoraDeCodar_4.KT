package Ex_1

// Para simplificar, usaremos uma ArrayList para armazenar os registros e um menu para navegar entre as opções.
fun main() {
    val registros = ArrayList<Registro>()
    var opcao: Int

    do {
        println("Agenda - Escolha uma opção:")
        println("1. Cadastrar registros")
        println("2. Pesquisar registro pelo nome")
        println("3. Classificar registros por nome")
        println("4. Apresentar todos os registros")
        println("5. Sair")

        print("Digite sua opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarRegistros(registros)
            2 -> pesquisarRegistro(registros)
            3 -> ordenarRegistros(registros)
            4 -> exibirRegistros(registros)
            5 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 5)
}

//---------------------------------------------------------------
//Aqui vamos abrir a primeira função, a de registros

fun cadastrarRegistros(registros: ArrayList<Registro>) {
    println("\nCadastro de registros:")
    for (i in 1..10) {
        println("Cadastro ${i}:")

        print("Nome: ")
        val nome = readLine() ?: ""

        print("Endereço: ")
        val endereco = readLine() ?: ""

        print("Telefone: ")
        val telefone = readLine() ?: ""

        registros.add(Registro(nome, endereco, telefone))
    }
    println("Cadastro concluído com sucesso!\n")
}

//------------------------------------------------------------------
// Aqui abrimos uma função para pesquisar os registros

fun pesquisarRegistro(registros: ArrayList<Registro>) {
    print("\nDigite o nome para a busca: ")
    val nomeBuscado = readLine() ?: ""

    val resultado = registros.find { it.nome.equals(nomeBuscado, ignoreCase = true) }

    if (resultado != null) {
        println("Ex_1.Registro encontrado: $resultado\n")
    } else {
        println("Nenhum registro encontrado para o nome \"$nomeBuscado\".\n")
    }
}

//------------------------------------------------------------------
//Ordenaremos a lista em ordem alfabética com sortBy.

fun ordenarRegistros(registros: ArrayList<Registro>) {
    registros.sortBy { it.nome }
    println("Registros classificados em ordem alfabética.\n")
}

//------------------------------------------------------------------
// Listamos os registros para exibir todas as entradas.

fun exibirRegistros(registros: ArrayList<Registro>) {
    println("\nLista de todos os registros:")
    registros.forEach { println(it) }
    println()
}
