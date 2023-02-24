// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kOperatorControllerPort = 1;
  }
 public static class GripperC {
    public static final int rightMotor = 62;
    public static final int leftMotor = 61;
    public static final int GripperMotor = 60;
    public static final int GripperCANifier = 59;
    public static boolean leftMotorReversed = true;
    public static boolean rightMotorReversed = false;
 } 

 public static class xboxButtons {
    public static final int A_BUTTON = 0;
    public static final int B_BUTTON = 1;
    public static final int X_BUTTON = 2;
    public static final int Y_BUTTON = 3;
 }
}
