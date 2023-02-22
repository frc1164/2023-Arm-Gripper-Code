// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.GripperC;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.GeneralPin;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.sensors.*;


public class Gripper extends SubsystemBase {
  private final CANSparkMax rightDrive;
  private static CANSparkMax leftDrive;
  private final CANSparkMax clasp;

  private final RelativeEncoder StickerEncoder;
  private final RelativeEncoder NormalEncoder;

  private final DigitalInput openlimitSwitch;
  private final DigitalInput closedlimitSwitch;
  private static DigitalInput pieceSwitch;

  private static CANifier m_canifier;
  private final GeneralPin m_openSwitch;
  private final GeneralPin m_closedSwitch;


  /** Creates a new Gripper. */
  public Gripper() {
    rightDrive = new CANSparkMax(GripperC.StickerMotor, MotorType.kBrushless);
    leftDrive = new CANSparkMax(GripperC.NormalMotor, MotorType.kBrushless);
    clasp = new CANSparkMax(GripperC.GripperMotor, MotorType.kBrushless);

    m_canifier = new CANifier(64);
    m_openSwitch = new GeneralPin(8);
    m_closedSwitch = new 


    StickerEncoder = rightDrive.getEncoder();
    NormalEncoder = leftDrive.getEncoder();

    openlimitSwitch = new DigitalInput(2);
    closedlimitSwitch = new DigitalInput(1);
    pieceSwitch = new DigitalInput (0);
  }

  public void resetEncoders() {
    StickerEncoder.setPosition(0);
    NormalEncoder.setPosition(0);
  }
  
  public double getStickerPosition() {
    return StickerEncoder.getPosition();
  }
  
  public double getNormalPosition() {
    return NormalEncoder.getPosition();
  }
  
  public double getStickerVelocity() {
    return StickerEncoder.getVelocity();
  }
  
  public double getNormalVelocity() {
    return NormalEncoder.getVelocity();
  }

  public void Intake(double speed) {
    if (speed > 0)
        if(rightDrive.getOutputCurrent() > 6){
          rightDrive.set(0);
          leftDrive.set(0);
        } else {
          rightDrive.set(speed);
          leftDrive.set(speed);
        }
  }
  
  public void clasp(double speed) {
    if (speed < 0) {
        if (!closedlimitSwitch.get()) {
            // We are going up and top limit is tripped so stop
            clasp.set(0);
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            clasp.set(speed);
        }
    } else {
        if (!openlimitSwitch.get()) {
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
