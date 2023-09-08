enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val nome: String) {
    
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    val alunosMatriculados = mutableListOf<Aluno>()

    fun matricularAluno(aluno: Aluno) {
        alunosMatriculados.add(aluno)
        val totalHoras = conteudos.sumBy { it.duracao }
        println("${aluno.nome} foi matriculado(a) no curso de $nome (${nivel.name.toLowerCase()}) - $totalHoras horas.")
    }

    fun listarAlunosMatriculados() {
        println("Alunos matriculados no curso de $nome (${nivel.name.toLowerCase()}):")
        for (aluno in alunosMatriculados) {
            println(aluno.nome)
        }
    }
}

fun main() {
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 120)
    val conteudo3 = ConteudoEducacional("Banco de Dados", 75)
    val conteudo4 = ConteudoEducacional("Kotlin | Programação Orientada a Objetos", 98)

    // Criando algumas formações
    val formacao1 = Formacao("Desenvolvimento de Software", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Web Development", Nivel.BASICO, listOf(conteudo1, conteudo3))
    val formacao3 = Formacao("Kotlin Programação Orientada a Objetos", Nivel.AVANCADO, listOf(conteudo4))

    // Criando alguns alunos
    val aluno1 = Aluno("Alice")
    val aluno2 = Aluno("Bob")

    
    formacao1.matricularAluno(aluno1)
    formacao2.matricularAluno(aluno1)
    formacao2.matricularAluno(aluno2)
    formacao3.matricularAluno(aluno2)
}
