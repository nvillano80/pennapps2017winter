#include <Time.h>
#include <TimeLib.h>
#include <LiquidCrystal.h>

// select the pins used on the LCD panel
LiquidCrystal lcd(8, 9, 4, 5, 6, 7);
//SoftwareSerial portOne(0, 1); // RX, TX

// define some values used by the panel and buttons
int lcd_key     = 0;
int adc_key_in  = 0;
#define btnRIGHT  0
#define btnUP     1
#define btnDOWN   2
#define btnLEFT   3
#define btnSELECT 4
#define btnNONE   5

// read the buttons
int read_LCD_buttons() {
  adc_key_in = analogRead(0);      // read the value from the sensor
  // my buttons when read are centered at these valies: 0, 144, 329, 504, 741
  // we add approx 50 to those values and check to see if we are close
  if (adc_key_in > 1000) return btnNONE; // We make this the 1st option for speed reasons since it will be the most likely result
  // For V1.1 us this threshold
  if (adc_key_in < 50)   return btnRIGHT;
  if (adc_key_in < 250)  return btnUP;
  if (adc_key_in < 450)  return btnDOWN;
  if (adc_key_in < 650)  return btnLEFT;
  if (adc_key_in < 850)  return btnSELECT;

  // For V1.0 comment the other threshold and use the one below:
  /*
    if (adc_key_in < 50)   return btnRIGHT;
    if (adc_key_in < 195)  return btnUP;
    if (adc_key_in < 380)  return btnDOWN;
    if (adc_key_in < 555)  return btnLEFT;
    if (adc_key_in < 790)  return btnSELECT;
  */


  return btnNONE;  // when all others fail, return this...
}

int checkButtons() {
  switch (lcd_key)               // depending on which button was pushed, we perform an action
  {
    case btnRIGHT:
      {
        return btnRIGHT;
        break;
      }
    case btnLEFT:
      {
        return btnLEFT;
        break;
      }
    case btnUP:
      {
        return btnUP;
        break;
      }
    case btnDOWN:
      {
        return btnDOWN;
        break;
      }
    case btnSELECT:
      {
        return btnSELECT;
        break;
      }
    case btnNONE:
      {
        return btnNONE;
        break;
      }
  }
}

// pin will chirp
void chirp(int pin) {
  digitalWrite(pin, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(10);              // wait for a second
  digitalWrite(pin, LOW);    // turn the LED off by making the voltage LOW
  delay(1000);              // wait for a second
}
// pin will buzz
void buzz(int pin) {
  digitalWrite(pin, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1000);              // wait for a second
  digitalWrite(pin, LOW);    // turn the LED off by making the voltage LOW
  delay(1000);              // wait for a second
}
// if tillPunishment = 2, a punishment would be given every 2 seconds.
void alarmGo(int tillPunishment) {
  int timeRinging = 0; // in seconds
  while (btnSELECT != HIGH) {
    buzz(2); // takes 2 seconds
    timeRinging += 2;

    if (timeRinging % tillPunishment == 0 && timeRinging != 0) {
      Serial.println("Donate");
    }
  }
}

//==========================================================================//

void printTime() {
  lcd.setCursor(0, 0);
  lcd.print((String)hour() + ":" + minute() + ":" + second());
}

int cursorPos = 0; // 0=none 1=hr 2=min 3=on/off

int alarmHour = 0;
int alarmMinute = 0;
int alarmSecond = 0;

void printAlarm() {
  lcd.setCursor(0, 1);
  lcd.print((String) alarmHour + ":" + alarmMinute + ":" + alarmSecond);
}

void setup() {
  Serial.begin(9600);
  //  while (!Serial) {
  //
  //  }
  //  portOne.begin(9600);
  pinMode(2, OUTPUT); // buzzer
  lcd.begin(16, 2);
}

int screenNum = 0;
void loop() {
  //Serial.println(now());
  //delay(1000);
  if (screenNum == 0) {
    screenNum = mainScreen();
    if (screenNum != 0) {
      lcd.clear();
    }
  } else if (screenNum == 1) {
    screenNum = setScreen();
    if (screenNum != 1) {
      lcd.clear();
    }
  }
}
boolean mainCleared = false;
int mainScreen() {
  if (second() == 0 && !mainCleared) {
    lcd.clear();
    mainCleared = true;
  } else if (second() == 1) {
    mainCleared = false;
  }
  printTime();
  printAlarm();
  lcd_key = read_LCD_buttons();  // read the buttons
  int button = checkButtons();
  if (button == btnNONE) { //button == none
    return 0;
  } else if (button == btnSELECT) { // button == select
    return 1;
  }
}

boolean setCleared = false;
int setScreen() {
  if (second() == 0 && !setCleared) {
    lcd.clear();
    setCleared = true;
  } else if (second() == 1) {
    setCleared = false;
  }
  printTime();
  printAlarm();
  lcd.setCursor(13, 0);
  lcd.print("SET");
  return 1;
}

