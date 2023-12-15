from os import environ
from dotenv import load_dotenv
from datetime import datetime
import paho.mqtt.client as paho
import json
import random

load_dotenv(dotenv_path='./.env')

BROKER = environ.get("MQTT_HOST")
PORT = int(environ.get("MQTT_PORT"))
USERNAME = environ.get("MQTT_CLIENT_USER")
PASSWORD = environ.get("MQTT_CLIENT_PASS")

MQTT_TOPIC_PUBLISHED_OPS= environ.get("MQTT_TOPIC_PUBLISHED_OPS")
MQTT_TOPIC_ACK = environ.get("MQTT_TOPIC_ACK")
MQTT_TOPIC_COMPLETED=environ.get("MQTT_TOPIC_COMPLETED")
MQTT_TOPIC_REJECTED=environ.get("MQTT_TOPIC_REJECTED")

print (MQTT_TOPIC_PUBLISHED_OPS)

device = {
     "id": 2,
     "name": "SamplePython"
}
message = {
    "content": "Mensaje de prueba metaIoT",
    "device": device
}

def on_connect(client, userdata, flags, rc):
    print(f'Connected: {rc}')

def on_publish(client, userdata, mid):
    print('Data published')

def on_message(client, userdata, msg):
        print(f"Message received: {msg.payload.decode()} in topic {msg.topic}")
        operation = json.loads(msg.payload.decode())
        message['operation'] = operation
        id_field = str(operation.get('id', ''))
        client.publish(MQTT_TOPIC_ACK + '/' + id_field, json.dumps(message))

        number = random.randint(1, 2)
        if number == 1:
            message['content'] = message['content'] + ' COMPLETADO'
        else:
            message['content'] = message['content'] + ' RECHAZADO'

        client.publish(MQTT_TOPIC_COMPLETED + '/' + id_field, json.dumps(message))



client = paho.Client("sampleClient", transport='websockets')

client.on_connect = on_connect
client.on_publish = on_publish
client.on_message = on_message

client.username_pw_set(USERNAME, PASSWORD)

client.connect(BROKER, PORT, 60)
client.subscribe(MQTT_TOPIC_PUBLISHED_OPS + '/#')
client.loop_forever()