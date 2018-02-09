package subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import constants.Const;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import objects.Action;

public class arms extends Action {
	DoubleSolenoid pistonL,pistonR;
	TalonSRX intakeL,intakeR;
	public arms() {
		pistonL = new DoubleSolenoid(Const.armLFwd, Const.armLRev);
		pistonR = new DoubleSolenoid(Const.armRFwd, Const.armRRev);
		intakeL = new TalonSRX(Const.armLIntake);
		intakeR = new TalonSRX(Const.armRIntake);
	}
	/**Closes arms*/
	public void grab() {
		pistonL.set(DoubleSolenoid.Value.kForward);
		pistonR.set(DoubleSolenoid.Value.kForward);
		
	}
	/**Opens arms*/
	public void release() {
		pistonL.set(DoubleSolenoid.Value.kReverse);
		pistonR.set(DoubleSolenoid.Value.kReverse);
	}
	/**Makes intake take in*/
	public void takeIn(double spped) {
		intakeL.set(ControlMode.PercentOutput, spped);
		intakeR.set(ControlMode.PercentOutput, spped);
	}
	/**Makes intake push out*/
	public void takeOut(double spped) {
		intakeL.set(ControlMode.PercentOutput, -spped);
		intakeR.set(ControlMode.PercentOutput, -spped);
	}
	/**Runs only the left intake motor*/
	public void runL(double spped) {
		intakeL.set(ControlMode.PercentOutput, spped);
	}
	/**Runs only the right intake motor*/
	public void runR(double spped) {
		intakeR.set(ControlMode.PercentOutput, spped);
	}
	/**Stops all intake motors*/
	public void stop() {
		intakeL.set(ControlMode.PercentOutput, 0);
		intakeR.set(ControlMode.PercentOutput, 0);
	}
	/**Stops intake motors and sets pistons to off position*/
	public void reset() {
		stop();
		release();
	}
}
