#!/bin/bash

# Esperar a que RabbitMQ esté disponible
sleep 10

# Utilizar el comando `rabbitmqadmin` para crear las colas
# rabbitmqadmin es una herramienta de línea de comandos que puede instalarse mediante el complemento de administración de RabbitMQ o en contenedores de imágenes preconfiguradas que incluyan esta herramienta.

# Crear la cola1
rabbitmqadmin declare queue name=cuenta durable=true

# Crear la cola2
rabbitmqadmin declare queue name=cliente durable=true

echo "Colas creadas correctamente."