// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.BoardBot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BoardBot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class RunMotors extends CommandBase {
  private final BoardBot BoardBot;
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  

  /**
   * Creates a new RunMotors.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunMotors(BoardBot subsystem) {
    BoardBot = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //where subsystem functions run//
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
