// ===== ABSTRACT PRODUCTS =====

interface Question {
    void show();
}

interface Grading {
    void calculate();
}

interface Feedback {
    void showFeedback();
}

interface Delivery {
    void deliver();
}

// ===== ABSTRACT FACTORY =====

interface EvaluationFactory {
    Question createQuestion();
    Grading createGrading();
    Feedback createFeedback();
    Delivery createDelivery();
}

// ===== TRADITIONAL PRODUCTS =====

class MultipleChoiceQuestion implements Question {
    public void show() {
        System.out.println("Multiple choice question.");
    }
}

class NumericGrading implements Grading {
    public void calculate() {
        System.out.println("Numeric grading over 100.");
    }
}

class BasicFeedback implements Feedback {
    public void showFeedback() {
        System.out.println("Basic textual feedback.");
    }
}

class PDFDelivery implements Delivery {
    public void deliver() {
        System.out.println("Exam delivered as PDF.");
    }
}

// ===== TRADITIONAL FACTORY =====

class TraditionalEvaluationFactory implements EvaluationFactory {

    public Question createQuestion() {
        return new MultipleChoiceQuestion();
    }

    public Grading createGrading() {
        return new NumericGrading();
    }

    public Feedback createFeedback() {
        return new BasicFeedback();
    }

    public Delivery createDelivery() {
        return new PDFDelivery();
    }
}

// ===== GAMIFIED PRODUCTS =====

class ChallengeQuestion implements Question {
    public void show() {
        System.out.println("Interactive challenge question.");
    }
}

class AchievementGrading implements Grading {
    public void calculate() {
        System.out.println("Grading based on achievements.");
    }
}

class VisualFeedback implements Feedback {
    public void showFeedback() {
        System.out.println("Visual feedback with badges.");
    }
}

class InteractiveDelivery implements Delivery {
    public void deliver() {
        System.out.println("Delivered through interactive platform.");
    }
}

// ===== GAMIFIED FACTORY =====

class GamifiedEvaluationFactory implements EvaluationFactory {

    public Question createQuestion() {
        return new ChallengeQuestion();
    }

    public Grading createGrading() {
        return new AchievementGrading();
    }

    public Feedback createFeedback() {
        return new VisualFeedback();
    }

    public Delivery createDelivery() {
        return new InteractiveDelivery();
    }
}

// ===== CLIENT =====

class ExamGenerator {

    private Question question;
    private Grading grading;
    private Feedback feedback;
    private Delivery delivery;

    public ExamGenerator(EvaluationFactory factory) {
        question = factory.createQuestion();
        grading = factory.createGrading();
        feedback = factory.createFeedback();
        delivery = factory.createDelivery();
    }

    public void generateExam() {
        question.show();
        grading.calculate();
        feedback.showFeedback();
        delivery.deliver();
    }
}

// ===== MAIN (ONLY PUBLIC CLASS) =====

public class Main {

    public static void main(String[] args) {

        // Switch factory here
        EvaluationFactory factory = new GamifiedEvaluationFactory();
        // Try:
        // EvaluationFactory factory = new TraditionalEvaluationFactory();

        ExamGenerator exam = new ExamGenerator(factory);
        exam.generateExam();
    }
}