# RestAssured e Cucumber

Projeto test de api rest realizando validação de cadastro de pessoa 

## Oque foi aprendido

Uma abordagem interessante na disposição dos testes utilizando framework bdd, onde é possível realizar vários cenários de teste utilizando uma tabela de exemplo e durante os testes a tabela se torna um objeto modelo que auxilia nos testes.

```bash
    Examples:                                                                     
      | casoDeTeste             |resultadoEsperado| statusCode | nome             
      | Cadastro de pessoa      |SUCESS           | 201        | Rafael Teixeira  
      | CPF ja existe           |FAIL             | 400        | Jefferson Bruno  
      | Telefone ja existe      |FAIL             | 400        | Bruna Carvalho   
      | Cadastro de nova pessoa |SUCESS           | 201        | Vivian Azevedo   
```

## Conhecimento adiquirido

Durante a construção do projeto acabei conhecendo o Serenity que de acordo com eles "O Serenity também usa os resultados do teste para produzir relatórios narrativos ilustrados que documentam e descrevem o que seu aplicativo faz e como ele funciona. O Serenity informa não apenas quais testes foram executados, mas, mais importante, quais requisitos foram testados.". O ponto forte que trás uma nova abordagem em padrão de projeto de testes automatizados chamado de Screenplay onde é possível descrever passos que auxilian das chamadas de execucao de métodos do cucumber através da feature.
![Image description](http://serenity-bdd.info/docs/articles/images/screenplay.png)
Infelizmente não deu tempo para eu utilizar o Serenity no projeto de teste, mas vou estudar mais sobre essa nova abordagem, acredito que tem potencial futuro.

## Bugs encontrados

- Documentação para teste apresenta como GET "localhost:8080/{ddd}/{numero}" porem o endpoint correto para requisicao é "localhost:8080/pessoas/{ddd}/{numero}"
- Sistema apresena erro ao tentar incluir array de endereços e telefones com mais de um item dentro do array
- Sistema permite inserir pessoa com cpf e dados telefonicos inválidos
- Sistema apresenta erro ao incluir uma pessoa sem algumas propriedades como por exemplo "telefone", acredito que o sistema deve apresentar mensagem negocial para a situacao, informando que os campos xpto são obrigatórios
- Sistema apresenta erro ao realizar inclusao de pessoa com campos/dados acima de 255 caracteres

## Agradecimento
Agradeço a oportunidade de participar do processo, onde pude aprender ainda mais sobre projetos de teste utiliando cucumber.
