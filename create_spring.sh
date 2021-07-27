#!bash
mvn archetype:generate \
    -DinteractiveMode="false" \
    -DarchetypeCatalog="local" \
    -DarchetypeGroupId="za.co.vodacom.archetype" \
    -DarchetypeArtifactId="spring-boot-archetype" \
    -DarchetypeVersion="1.0.0-SNAPSHOT" \
    -DartifactId="vod-ms-customerInfo" \
    -DgroupId="za.co.vodacom.ms.customerInfo"\
    -Dteam="Cloud_Self_Service" \
    -DartifactName="customerInfo"
