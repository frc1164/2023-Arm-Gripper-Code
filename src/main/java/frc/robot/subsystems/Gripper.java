// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.GripperC;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.GeneralPin;
import com.ctre.phoenix.CANifier.PinValues;
import com.ctre.phoenix.sensors.*;


public class Gripper extends SubsystemBase {
  private static CANSparkMax rightDrive;
  private static CANSparkMax leftDrive;
  private static CANSparkMax clasp;

  private static RelativeEncoder rightEncoder;
  private static RelativeEncoder leftEncoder;
  private static RelativeEncoder claspEncoder;

  private static DigitalInput openlimitSwitch;
  private static DigitalInput closedlimitSwitch;
  private static DigitalInput pieceSwitch;

  private static CANifier m_canifier;
  private boolean m_openSwitch;
  private boolean m_closedSwitch;


  /** Creates a new Gripper. */
  public Gripper() {
    rightDrive = new CANSparkMax(GripperC.rightMotor, MotorType.kBrushless);
    rightDrive.setInverted(GripperC.rightMotorReversed);
    leftDrive = new CANSparkMax(GripperC.leftMotor, MotorType.kBrushless);
    leftDrive.setInverted(GripperC.leftMotorReversed);
    clasp = new CANSparkMax(GripperC.GripperMotor, MotorType.kBrushless);

    m_canifier = new CANifier(GripperC.GripperCANifier);

    rightEncoder = rightDrive.getEncoder();
    leftEncoder = leftDrive.getEncoder();
    claspEncoder = clasp.getEncoder();

    openlimitSwitch = new DigitalInput(2);
    closedlimitSwitch = new DigitalInput(1);
    pieceSwitch = new DigitalInput (0);
  }

  public void resetEncoders() {
    rightEncoder.setPosition(0);
    leftEncoder.setPosition(0);
  }
  
  public double getrightPosition() {
    return rightEncoder.getPosition();
  }
  
  public double getleftPosition() {
    return leftEncoder.getPosition();
  }
  
  public double getrightVelocity() {
    return rightEncoder.getVelocity();
  }
  
  public double getleftVelocity() {
    return leftEncoder.getVelocity();
  }

  public void Intake(double speed) {
   /*  if (speed > 0)
        if(rightDrive.getOutputCurrent() > 6){
          rightDrive.set(0);
          leftDrive.set(0);
        } else {*/
          rightDrive.set(speed);
          leftDrive.set(speed);
        }
  
  
  public void setClasp(double speed) {
    if (speed > 0) {
        if (getGripperOPENLimitSwitch()) {
            // We are going up and top limit is tripped so stop
            clasp.set(0);
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            clasp.set(speed);
        }
    } else {
        if (getGripperCLSDLimitSwitch()) {
            // We are going down and bottom limit is tripped so stop
            clasp.set(0);
        } else {
            // We are going down but bottom limit is not tripped so go at commanded speed
            clasp.set(speed);  
        }
       }
}
    
  public static void initreverseLeft(){
    leftDrive.setInverted(true);
  }


  public void setgripEncoder() {
    while (!m_openSwitch && !m_closedSwitch);
      clasp.set(-.25);
    clasp.set(0);
    claspEncoder.setPosition(0);
  }

  public static void gripToggle() {
    if (getGripperCLSDLimitSwitch()){
      clasp.set(.25);
      
      while (getGripperOPENLimitSwitch()){
      }

      clasp.set(0);

    }
    if(getGripperOPENLimitSwitch()){
      clasp.set(-.25);

      while(getGripperOPENLimitSwitch()){
      }
      
      clasp.set(0);
    }else{
      clasp.set(-.25);
    }

  }

public static boolean getGripperCLSDLimitSwitch() {
    return m_canifier.getGeneralInput(GeneralPin.LIMF);
}
public static boolean getGripperOPENLimitSwitch() {
    return m_canifier.getGeneralInput(GeneralPin.LIMR);
}

  /*public void setgripAngle(setpoint) {
    new PIDController(closed number, setpoint, 0)
  }*/


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Gripper Encoder", claspEncoder.getPosition());
    SmartDashboard.putBoolean("Forward Limit Switch", getGripperCLSDLimitSwitch());
    SmartDashboard.putBoolean("Rear Limit Switch", getGripperOPENLimitSwitch());
    
  }
}
