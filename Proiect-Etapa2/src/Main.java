import com.fasterxml.jackson.databind.ObjectMapper;
import reader.Input;
import stages.DoStages;
import writer.WriteOutput;

import java.io.File;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() {
    }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {

        //read the json file in the Input class
        ObjectMapper objectMapper = new ObjectMapper();
        Input input = objectMapper.readValue(new File(args[0]), Input.class);

        //declare a DoStages instance -> to do the simulation
        //for each turn, compute data
        DoStages data = new DoStages(input);
        data.doTurns();

        //declare output format file and add computed data
        WriteOutput output = new WriteOutput();
        output.formatOutput(data);

        //write the output json file in "pretty" format
        ObjectMapper outObjectMapper = new ObjectMapper();
        outObjectMapper.writeValue(new File(args[1]), output);

        //clear the consumer and distributor array lists to prepare for next test's input
        data.getMyConsumers().clear();
        data.getMyDistributors().clear();
        data.getMyProducers().clear();
    }
}
