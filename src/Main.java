import java.util.Scanner;

interface ResponseStrategy {
    String generateResponse(String question);
}

class SimpleTextResponse implements ResponseStrategy {
    @Override
    public String generateResponse(String question) {
        return "Thanks for your question. We'll get back to you shortly.";
    }
}

class ForwardToStaffResponse implements ResponseStrategy {
    @Override
    public String generateResponse(String question) {
        return "Your question has been forwarded to a customer service representative.";
    }
}

class Chatbot {
    private ResponseStrategy strategy;

    public Chatbot(ResponseStrategy strategy) {
        this.strategy = strategy;
    }

    public void respondTo(String question) {
        String response = strategy.generateResponse(question);
        System.out.println("Chatbot: " + response);
    }

    public void setStrategy(ResponseStrategy strategy) {
        this.strategy = strategy;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the webshop chatbot!");
        System.out.println("Type in your question: ");
        String vraag = scanner.nextLine();

        System.out.println("Choose strategy: (1) Simple answer, (2) Forward question");
        int keuze = scanner.nextInt();

        ResponseStrategy strategy;

        if (keuze == 1) {
            strategy = new SimpleTextResponse();
        } else if (keuze == 2) {
            strategy = new ForwardToStaffResponse();
        } else {
            System.out.println("Invalid choice. Standard strategy applied.");
            strategy = new SimpleTextResponse();
        }

        Chatbot bot = new Chatbot(strategy);
        bot.respondTo(vraag);
    }
}
