# Properties Changer

## Build

`mvn clean package -DskipTests`

## Build native

`mvn clean package -DskipTests -Pnative`

## Usage jar

`java -jar target/pc-jar-with-dependencies.jar -f <path to props file> -k <key> -v <value>`

## Usage native

`target/pc -f <path to props file> -k <key> -v <value>`
