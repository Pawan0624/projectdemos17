from openjdk

ADD dockerdemo-0.0.1-SNAPSHOT.jar /

EXPOSE 9900

CMD ["java","-jar","dockerdemo-0.0.1-SNAPSHOT.jar"]



