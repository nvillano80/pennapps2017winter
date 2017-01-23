#Snooze You Lose
###Rohan Jhunjhunwala & Nick Villano

#### Description
Waking up is difficult. Especially after a sleepless weekend at PennApps! Now everyone can capitalize on those challanging morning hours. With *Snooze You Lose*, you are rewarded when you wake up on time and when you hit snooze. Every time you hit snooze, the clock donates one of your dollars to a charitable organization near to your heart. The device is a true example of a win-win situation. If you wake up on time you save money. If you are late for work, at least you can say it was because of your good morals.

The clock features an adjustable 24-hour clock and alarm with up to the second accuracy. The alarm can be toggled on and off and with only five buttons the controls are simple and easy to learn. The clock also has a beautyful display stand that will look amazing in any room.

*Note: The alarm clock uses the Nessie- the Capital One Hackathon API, to simulate the donations to charity.*

#### Instructions
In order to make the alarm, upload the ArduinoAlarm project folder to an Arduino Uno with a buzzer attached to pin 2 and an LCD shield. Then, upload the RaspberryPiAlarm folder to a Raspberry Pi with an internet connection and run the python script in the Python 3 IDE. Finally, plug the Arduino into a USB port on the Raspberry Pi. You may have to try different USB ports in order to find the one that the Python script is looking for. You should plug the Arduino into each port twice before attempting to use another port because the USB ports toggle between two names for some reason.
