int ledVerde=9;
int ledRojo=10;
int sensorProximidad=A0;
int sensorFotoA=A1;
int buzzer=6;
int trigger=7;
int echo=8;
int boton=2;
int estadoAlarma=0;
int proximidad=A0;
int temp=A2;
int dist=10;
String input="\0";
void setup() {
  Serial.begin(9600);
  pinMode(echo,INPUT);
  pinMode(trigger,OUTPUT);
  pinMode(proximidad,INPUT);
  pinMode(ledVerde,OUTPUT);
  pinMode(ledRojo,OUTPUT);
  pinMode(buzzer,OUTPUT);
  pinMode(sensorProximidad,INPUT);
  pinMode(sensorFotoA,INPUT);
  pinMode(temp,INPUT);
  attachInterrupt(digitalPinToInterrupt(boton),resetearAlarma,RISING);
}

void loop() {
  luz();
  while(input.equals("distancia")){
    Serial.println("introduce la distancia nueva");
    if(!input.equals("distancia"))
      dist=input.toInt();
  }
  while (distancia()<dist || analogRead(proximidad)<512){
    luz();
    estadoAlarma=1;
    digitalWrite(ledRojo,HIGH);
    if(analogRead(proximidad)<512 && distancia()<20)
      estadoAlarma=2;
      int rep=0;
    while(estadoAlarma>=2 && !input.equals("reset")){
      activarAlarma();
      
    }
    imprimirSensores();
  }
  estadoAlarma=0;
  digitalWrite(ledRojo,LOW);
  imprimirSensores();
}

void resetearAlarma(){
  estadoAlarma=0;
}

void activarAlarma(){
  digitalWrite(ledVerde,LOW);
  digitalWrite(ledRojo,HIGH);
  digitalWrite(buzzer,HIGH);
  delay(100);
  digitalWrite(ledRojo,LOW);
  digitalWrite(buzzer,LOW);
  delay(100);
  imprimirSensores();
}

int distancia(){
  digitalWrite(trigger,HIGH);
  delayMicroseconds(10);
  digitalWrite(trigger,LOW);
  delayMicroseconds(5);
  long tiem=pulseIn(echo,HIGH);
  long dis=tiem/59;
  if(dist>300)
    return 300;
  return dis;
}

int temperatura(){
  int value = analogRead(temp);
  float millivolts = (value / 1023.0) * 5000;
  float celsius = millivolts / 10;
  return celsius;
}

int luz(){
  int brillo1=map(analogRead(sensorFotoA),0,1023,0,200);
  if(brillo1<50)
    digitalWrite(ledVerde,HIGH);
  else if(brillo1>50)
    digitalWrite(ledVerde,LOW); 
  return brillo1;
}

void imprimirSensores(){
  Serial.print("distancia=");
  delay(10);
  Serial.println(distancia());
  delay(10);
  Serial.print("temperatura=");
  delay(10);
  Serial.println(temperatura());
  delay(10);
  Serial.print("luz=");
  delay(10);
  Serial.println(luz());
  delay(10);
  Serial.print("proximidad=");
  delay(10);
  Serial.println(analogRead(proximidad));
  delay(10);
}

