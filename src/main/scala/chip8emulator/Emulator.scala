package chip8emulator

case class Emulator(memory: Memory)

object Emulator {

  def main(args: Array[String]) {
    val rom = Memory.loadRom("C:\\Users\\Administrator\\Desktop\\Programming\\Scala\\src\\main\\scala\\chip8emulator\\TETRIS")
    println(rom)
  }

//  def opcodeToInstruction(opcode: Int): Instruction = {
//      ???
//    }
//
//  def executeOpcode(memory: Memory): Emulator = {
//      ???
//    }
//
//  def mainEmulationLoop: Boolean = {
//      ???
//  }
}
