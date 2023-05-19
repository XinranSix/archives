from PIL import ImageGrab
import os
import time


def screen(name):
    png = ImageGrab.grab()
    screen_path = os.path.join(os.path.dirname(__file__), 'screen')
    if not os.path.exists(screen_path):
        os.makedirs(screen_path)
    image_name = os.path.join(screen_path, name)
    t = time.strftime('%Y%m%d_%H%M%S', time.localtime())
    png.save('%s_%s.png' % (image_name, t))


def timer(n):
    while True:
        screen('test')


if __name__ == "__main__":
    timer(2)
