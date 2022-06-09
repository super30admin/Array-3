using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    class HIndex
    {
        /*
         * T.C: O(n) where n is no of citations
         * S.c: O(n) buckets array contains the number of papers
         */
        public int findHIndex(int[] citations)
        {
            if (citations == null || citations.Length == 0)
                return 0;

            int n = citations.Length;
            int[] buckets = new int[n + 1];

            for (int i = 0; i < citations.Length; i++)
            {
                if (citations[i] >= n)
                {
                    buckets[n]++;
                }
                else
                {
                    buckets[citations[i]]++;
                }
            }

            int sum = 0;

            for (int i = n; i >= 0; i--)
            {
                sum += buckets[i];

                if (sum >= i)
                {
                    return i;
                }
            }

            return -1;
        }
    }
}
