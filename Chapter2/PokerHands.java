import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PokerHands
{
    public enum CardFace { Clubs, Diamonds, Hearts, Spades }
    public enum Rank { HighCard, Pair, TwoPair, ThreeKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush }
    public enum WinLoseTie { Lose, Tie, Win }

    static class Hand
    {
        public List<Card> Cards;
        public Rank Rank;
        public int RankValue;
        public int[] valueArray = new int[14];
        public Hand(List<Card> Cards)
        {
            this.Cards = Cards;
            EvaluateHand();
        }

        private void EvaluateHand()
        {
            Rank = PokerHands.Rank.HighCard;
            int HighCard = Integer.MIN_VALUE;
            int FinalValue = 0;
            int ConsecutiveCount =0;
            int[] FaceCount = new int[4];
            for(Card c : Cards)
            {
                if(c.Value > HighCard)
                    HighCard = c.Value;
                valueArray[c.Value-1]++;
                FaceCount[c.Face.ordinal()]++;

                if(FaceCount[c.Face.ordinal()] == 5)
                    Rank = this.Rank.Flush;
            }
            for(int i=0;i<valueArray.length;i++)
            {
                int currentValue = valueArray[i];
                if(currentValue==0)
                    ConsecutiveCount = 0;
                else
                    ConsecutiveCount++;

                if(ConsecutiveCount == 5)
                {
                    FinalValue = i+1;
                    if(Rank == this.Rank.Flush)
                        Rank = PokerHands.Rank.StraightFlush;
                    else
                        Rank = this.Rank.Straight;
                }
                else if(Rank != PokerHands.Rank.Flush)
                {
                    if (currentValue == 2)
                    {
                        if (Rank == PokerHands.Rank.ThreeKind)
                        {
                            Rank = PokerHands.Rank.FullHouse;
                        }
                        else if(Rank == this.Rank.Pair)
                        {
                            Rank = this.Rank.TwoPair;
                            FinalValue = i+1;
                        }
                        else
                        {
                            Rank = this.Rank.Pair;
                            FinalValue = i+1;
                        }
                    }
                    if (currentValue == 3)
                    {
                        FinalValue = i+1;
                        if (Rank == this.Rank.Pair)
                        {
                            Rank = PokerHands.Rank.FullHouse;
                        }
                        else
                        {
                            Rank = this.Rank.ThreeKind;
                        }
                    }
                    if (currentValue == 4)
                    {
                        Rank = this.Rank.FourOfAKind;
                        FinalValue = i+1;
                    }
                }
            }
            if(Rank == PokerHands.Rank.HighCard)
            {
                FinalValue = HighCard;
            }
            RankValue = FinalValue;
        }

        public WinLoseTie CompareTo(Hand hand)
        {
            WinLoseTie Value = null;
            if(this.Rank.ordinal() == hand.Rank.ordinal())
            {
                if (this.RankValue > hand.RankValue)
                    Value = WinLoseTie.Win;
                else if(this.RankValue < hand.RankValue)
                    Value = WinLoseTie.Lose;
                else
                    Value = HighCardRank(hand, Value);
            }
            else if(this.Rank.ordinal() > hand.Rank.ordinal())
            {
                Value = WinLoseTie.Win;
            }
            else if(this.Rank.ordinal() < hand.Rank.ordinal())
            {
                Value = WinLoseTie.Lose;
            }
            return Value;
        }

        private WinLoseTie HighCardRank(Hand hand, WinLoseTie value)
        {
            //Rankvalue is the same
            for (int i = this.valueArray.length-1; i >= 0; i--)
            {
                if(i != this.RankValue-1)
                {
                    if (this.valueArray[i] != 0 && hand.valueArray[i] != 0)
                    {
                        value = WinLoseTie.Tie;
                    } else if (this.valueArray[i] != 0)
                    {
                        value = WinLoseTie.Win;
                        break;
                    } else if (hand.valueArray[i] != 0)
                    {
                        value = WinLoseTie.Lose;
                        break;
                    }
                }
            }
            return value;
        }
    }

    static class Card
    {
        public CardFace Face;
        public int Value;
        public Card(CardFace face, int value)
        {
            this.Face = face;
            this.Value = value;
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            String[] Input = scan.nextLine().split(" ");
            List<Card> BlackCards = new ArrayList<Card>();
            List<Card> WhiteCards = new ArrayList<Card>();

            for (int i = 0; i < 5; i++)
                BlackCards.add(ExtractCard(Input[i]));
            for (int i = 5; i < 10; i++)
                WhiteCards.add(ExtractCard(Input[i]));

            Hand blackHand = new Hand(BlackCards);
            Hand whiteHand = new Hand(WhiteCards);
            WinLoseTie wlt = blackHand.CompareTo(whiteHand);
            if (wlt == WinLoseTie.Win)
                System.out.println("Black wins.");
            else if (wlt == WinLoseTie.Lose)
                System.out.println("White wins.");
            else if (wlt == WinLoseTie.Tie)
                System.out.println("Tie.");
        }

    }

    public static Card ExtractCard(String Input)
    {
        int value = Character.getNumericValue(Input.charAt(0));
        CardFace face = null;
        switch (Input.charAt(0))
        {
            case 'T':
                value = 10;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
        }
        switch (Input.charAt(1))
        {
            case 'H':
                face = CardFace.Hearts;
                break;
            case 'D':
                face = CardFace.Diamonds;
                break;
            case 'S':
                face = CardFace.Spades;
                break;
            case 'C':
                face = CardFace.Clubs;
                break;
        }
        return new Card(face, value);
    }
}