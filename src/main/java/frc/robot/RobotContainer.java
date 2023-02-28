// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Clasp;
import frc.robot.commands.ConePickup;
import frc.robot.commands.CubePickup;
import frc.robot.commands.intake;
import frc.robot.commands.output;
import frc.robot.Constants.GripperC;
import frc.robot.subsystems.Gripper;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final Gripper m_gripper;
  private final CommandXboxController m_controller;

  // Replace with CommandPS4Controller or CommandJoystick if needed
 // private final CommandXboxController m_driverController =
      //new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_gripper = new Gripper();
    m_controller = new CommandXboxController(OperatorConstants.kOperatorControllerPort);

    
    m_gripper.setDefaultCommand(new Clasp(m_gripper, m_controller));


    /* m_intake = new intake(m_gripper);
    m_output = new output(m_gripper);
    m_cubePickup = new CubePickup(m_gripper);
    m_conePickup = new ConePickup(m_gripper);
    m_gripManual = new Clasp(m_gripper); */

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    /*new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));*/

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
   // m_controller.x().whileTrue(BoardBot.setintakeInward());
// new JoystickButton(m_controller, xboxButtons.X_BUTTON).onTrue(new intake(m_gripper, m_controller));
//   new JoystickButton(m_controller, xboxButtons.Y_BUTTON).onTrue(new output(m_gripper, m_controller));



Trigger aButton = m_controller.a();
Trigger bButton = m_controller.b();
Trigger yButton = m_controller.y();
Trigger xButton = m_controller.x();
Trigger lBumper = m_controller.leftBumper();
Trigger rBumper = m_controller.rightBumper();
//t
lBumper.whileTrue(new CubePickup(m_gripper));
rBumper.whileTrue(new ConePickup(m_gripper));
xButton.whileTrue(new intake (m_gripper));
aButton.whileTrue(new output (m_gripper));
bButton.onTrue(new InstantCommand(() -> Gripper.gripToggle()));

 //  new JoystickButton(m_controller, xboxButtons.B_BUTTON).onTrue(new ConePickup(m_gripper, m_controller));
   // new JoystickButton(m_controller, (int) m_controller.getRawAxis(5)).whileTrue(m_gripManual);

    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
