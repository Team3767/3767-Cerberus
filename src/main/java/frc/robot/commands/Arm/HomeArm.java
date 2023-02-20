package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class HomeArm extends CommandBase{
    private final Arm arm;

    public HomeArm(Arm arm) {
        this.arm = arm;
    }

    @Override
    public void initialize() {
        arm.setArmSpeed(-0.1);
    }

    @Override
    public void end(boolean isInterrupted) {
        arm.setArmSpeed(0);
        arm.resetArmEncoder();
        arm.setSoftLimits(10, 0);
        arm.enableSoftlimits(true);
    }

    @Override
    public boolean isFinished() {
        return arm.reverseLimitSwitch.get();
    }
}
