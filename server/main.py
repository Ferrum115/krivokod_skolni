import os
import socket
import uvicorn
from fastapi import FastAPI
from downloader import loadVid

#make easier to access
app = FastAPI()

#file transfer connection
cli = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
cli.connect(("localhost", 9000))

@app.get('/link/')
async def download(link: str):
    loadVid(link)
    return 200

@app.post('/send/file')
async def send(name: str):
    file = open(f'{name}.mp3', "rb")
    fsize = os.path.getsize(f'{name}.mp3')

    cli.send(f'{name}.mp3'.encode())
    cli.send(str(fsize).encode())

    data = file.read()
    cli.sendall(data)
    cli.send(b"<END>")

    file.close()
    return 200




if __name__ == "__main__":
    uvicorn.run(app, host="127.0.0.1", port="9600")