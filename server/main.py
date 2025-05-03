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

#download audio via YouTube link
@app.get('/link/')
async def download(link: str):
    loadVid(link)
    return 200

#upload requested file to user's phone
@app.post('/send/file')
async def send(name: str):
    file = open(f'{name}.mp3', "rb") #get file name
    fsize = os.path.getsize(f'{name}.mp3') #read size

    cli.send(f'{name}.mp3'.encode()) #send file name
    cli.send(str(fsize).encode()) #send file size (for validation)

    data = file.read() #read file data
    cli.sendall(data) #send file data
    cli.send(b"<END>") #close data transmission

    file.close() #close file
    return 200


#run app
if __name__ == "__main__":
    uvicorn.run(app, host="127.0.0.1", port="9600")