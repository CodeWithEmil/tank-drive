// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();

  private final CommandXboxController controller =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  // The method below returns the Drivetrain so that it can be accessed anywhere else.
  // I only used it in Robot.java to configure the drivetrain, using drivetrain's
  // setConfig() method, when Teleop starts (teleopInit())
  public Drivetrain getDrive() {
    return drivetrain;
  }

  // Controller bindings are declared
  private void configureBindings() {
    drivetrain.setDefaultCommand(
            new RunCommand(
                    () -> drivetrain.drive(-controller.getLeftY(), controller.getRightX()),
                    drivetrain
            )
    );
  }

  public Command getAutonomousCommand() {
    return null;
  }
}

// Electronics Postulation — Emilio Nájera, 2025