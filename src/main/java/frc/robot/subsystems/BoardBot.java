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


public class BoardBot extends SubsystemBase {
  private final CANSparkMax m_rightDrive;
  private final CANSparkMax m_leftDrive;

  private final RelativeEncoder StickerEncoder;
  private final RelativeEncoder NormalEncoder;

  private final DigitalInput toplimitSwitch;
  private final DigitalInput bottomlimitSwitch;
  private final DigitalInput MechSwitch;


  /** Creates a new BoardBot. */
  public BoardBot() {
    m_rightDrive = new CANSparkMax(BoardConstants.StickerMotor, MotorType.kBrushless);
    m_leftDrive = new CANSparkMax(BoardConstants.NormalMotor, MotorType.kBrushless);

    StickerEncoder = m_rightDrive.getEncoder();
    NormalEncoder = m_leftDrive.getEncoder();

    toplimitSwitch = new DigitalInput(2);
    bottomlimitSwitch = new DigitalInput(1);
    MechSwitch = new DigitalInput (0);
  }

  

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
