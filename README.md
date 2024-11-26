# nsleilao

Este projeto utiliza o Quarkus, o Framework Java Supersônico e Subatômico.

Se você deseja saber mais sobre o Quarkus, por favor, visite o site oficial: <https://quarkus.io/>.

## Executando a aplicação no modo de desenvolvimento

Você pode executar sua aplicação no modo de desenvolvimento, que permite live coding, usando:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  O Quarkus agora vem com uma Dev UI, que está disponível apenas no modo de desenvolvimento em: <http://localhost:8080/q/dev/>.

## Pacotes e executando a aplicação

A aplicação pode baixar os pacotes utilizando:

```shell script
./mvnw package
```

O `quarkus-run.jar` gera o arquivo no`target/quarkus-app/` diretório.
Esteja ciente de que não se trata de um  _über-jar_  pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.


A aplicação agora pode ser executada usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se você deseja construir um über-jar, execute o seguinte comando:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

A aplicação, empacotada como um _über-jar_, agora pode ser executada usando: `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando:

```shell script
./mvnw package -Dnative
```

Ou, se você não tiver o GraalVM instalado, pode executar a construção do executável nativo em um contêiner usando:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/nsleilao-1.0.0-SNAPSHOT-runner`

Se você deseja aprender mais sobre como construir executáveis nativos, consulte <https://quarkus.io/guides/maven-tooling>.

## Guias Relacionados

- REST ([guia](https://quarkus.io/guides/rest)): Uma implementação Jakarta REST utilizando processamento em tempo de compilação e Vert.x. Esta extensão não é compatível com a extensão quarkus-resteasy, nem com qualquer uma das extensões que dependem dela.
- Hibernate ORM ([guia](https://quarkus.io/guides/hibernate-orm)): Defina seu modelo persistente com Hibernate ORM e Jakarta Persistence.
- JDBC Driver - H2 ([guia](https://quarkus.io/guides/datasource)): Conecte-se ao banco de dados H2 via JDBC.
- SmallRye OpenAPI ([guia](https://quarkus.io/guides/openapi-swaggerui)): Documente suas APIs REST com OpenAPI - inclui o Swagger UI.
- REST Jackson ([guia](https://quarkus.io/guides/rest#json-serialisation)): Suporte à serialização Jackson para REST no Quarkus. Esta extensão não é compatível com a extensão quarkus-resteasy, nem com qualquer uma das extensões que dependem dela.

## Provided Code

### Hibernate ORM

Crie sua primeira entidade JPA

[Seção do guia relacionada...](https://quarkus.io/guides/hibernate-orm)



### REST

Inicie facilmente seus serviços REST Web

[Seção do guia relacionada...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


### JAVA 11

Para este projeto, foi utilizado o Java 11 para o correto funcionamento do banco de dados H2. Para isso, siga o passo a passo para a instalação.

## Pré-requisito:
- Será demonstrado para o Windowns, devido a ter sido o sistema operacional em que o projeto foi desenvolvido
- Acesso como administrador

### Baixar o JDK 11
## Oracle JDK
- Acesse o site oficial: Oracle Java SE Downloads.
- Escolha a versão Java SE 11 e selecione o instalador correspondente ao seu sistema operacional (Windows, macOS ou Linux).
    Observação: _Talvez seja necessário criar uma conta Oracle para baixar o JDK._

## OpenJDK
- Acesse o site oficial: Adoptium Temurin ou OpenJDK.
- Escolha a versão OpenJDK 11 e baixe o instalador ou o pacote comprimido apropriado para o seu sistema operacional.

## Instalando o Java 11
No Windows
- Execute o instalador baixado (.exe).
- Siga as instruções na tela.
- Durante a instalação, o instalador adicionará automaticamente o Java ao PATH do sistema e configurará o JAVA_HOME.

## Verificando a Instalação
- Depois de instalar, abra o terminal ou prompt de comando e digite:
```shell script
java -version
```

- O resultado deve mostrar a versão instalada do Java 11.

  
