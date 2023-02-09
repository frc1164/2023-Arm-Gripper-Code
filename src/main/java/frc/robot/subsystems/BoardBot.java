// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.BoardConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;


public class BoardBot extends SubsystemBase {
  private final CANSparkMax m_rightDrive;
  private final CANSparkMax m_leftDrive;
  private final CANSparkMax m_Gripper;

  private final RelativeEncoder StickerEncoder;
  private final RelativeEncoder NormalEncoder;

  private final DigitalInput toplimitSwitch;
  private final DigitalInput bottomlimitSwitch;
  private final DigitalInput MechSwitch;


  /** Creates a new BoardBot. */
  public BoardBot() {
    m_rightDrive = new CANSparkMax(BoardConstants.StickerMotor, MotorType.kBrushless);
    m_leftDrive = new CANSparkMax(BoardConstants.NormalMotor, MotorType.kBrushless);
    m_Gripper = new CANSparkMax(BoardConstants.GripperMotor, MotorType.kBrushless);

   // m_controller = new XboxController(0);

    StickerEncoder = m_rightDrive.getEncoder();
    NormalEncoder = m_leftDrive.getEncoder();

    toplimitSwitch = new DigitalInput(2);
    bottomlimitSwitch = new DigitalInput(1);
    MechSwitch = new DigitalInput (0);
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


  public void setintakeInward(){
    //m_rightDrive.set(m_controller.getRawAxis(5));
    //m_leftDrive.set(m_controller.getRawAxis(5));
    m_rightDrive.set(-.2);
    m_leftDrive.set(-.2);
  }

  public void initreverseRight(){
    m_rightDrive.setInverted(true);
  }

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
