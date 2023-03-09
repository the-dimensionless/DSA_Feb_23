package basic.design_patterns.behavioural;

interface StrategyInterface {
    public void compressFile(String fileName);
}

class CompressedToRar implements StrategyInterface {
    @Override
    public void compressFile(String fileName) {
        System.out.println(fileName + " compressed to Rar");
    }
}

class CompressedToZip implements StrategyInterface {
    @Override
    public void compressFile(String fileName) {
        System.out.println(fileName + " compressed to Zip");
    }
}

class Context {
    // this is as context class as it has the strategy object
    StrategyInterface compressionStrategy;

    public void generateFile(String fileName) {
        compressionStrategy.compressFile(fileName);
    }

    public void setCompressionStrategy(StrategyInterface compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }
}

public class Strategy {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setCompressionStrategy(new CompressedToRar());
        ctx.generateFile("Abc.txt");
    }
}
