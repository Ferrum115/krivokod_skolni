from pytubefix import YouTube
from pytubefix.cli import on_progress
import os

def loadVid(url: str):
    yt = YouTube(url, on_progress_callback=on_progress)
    print(yt.title)
    ys = yt.streams.get_audio_only()
    out = ys.download() #output_path="" custom path to load vid
    bse, ext = os.path.splitext(out)
    nfile = bse + ".mp3"
    os.rename(out, nfile)
    print("\n accepted")