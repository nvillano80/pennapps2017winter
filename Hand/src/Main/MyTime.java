/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Rohans
 */
public class MyTime {
 public int hours,minutes,seconds;
 public MyTime(int...a){
	 hours=a[0];
	 minutes=a[1];
	 seconds=a[2];
 }
 public boolean equals(MyTime m){
	 return this.minutes==m.minutes;
 }
}
