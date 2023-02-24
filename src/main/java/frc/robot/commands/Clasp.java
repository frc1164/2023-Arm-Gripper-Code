// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.GripperC;
import frc.robot.Constants.xboxButtons;
import frc.robot.subsystems.Gripper;

public class Clasp extends CommandBase {
  private final Gripper m_subsystem;
  private final XboxController m_controller;

  /** Creates a new Clasp. */
  public Clasp(Gripper subsystem, XboxController controller) {
    m_subsystem = subsystem;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.clasp(m_controller.getRawAxis(5)/4);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
